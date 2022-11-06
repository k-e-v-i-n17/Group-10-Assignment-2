import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Stack;

public class Group10Calculator implements ActionListener{

	JFrame frame;

	static JTextField textfield;
	JButton[] functionButtons = new JButton[8];
	JButton equButton,clrButton;
	JPanel panel;
	static String input;
	static String output;
	static int finalresult;
	static String exp;
	static double result;
	static boolean falseinput = false;

	Font myFont = new Font("Ariel", Font.BOLD,30);

	char operator;

	Group10Calculator (){

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);

		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);

		equButton = new JButton("=");
		clrButton = new JButton("Clear");

		functionButtons[0] = equButton;
		functionButtons[1] = clrButton;

		functionButtons[0].addActionListener(this);
		functionButtons[1].addActionListener(this);

		equButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);

		frame.add(equButton);
		frame.add(clrButton); 
		frame.add(textfield);

		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Group10Calculator calc = new Group10Calculator();
	}

	public static double evaluate(String expression)
	{
		falseinput = false;
		char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Double> values = new Stack<>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new Stack<>();

		// a valid expression will always have at least 3 tokens
		if (tokens.length <= 2){
			falseinput = true;
			return 0;
		}

		for (int i = 0; i < tokens.length; i++)
		{

			// Current token is a whitespace, skip it
			if (tokens[i] == ' ') continue;

			// Current token is a number, push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				//StringBuffer sbuf = new StringBuffer();
				StringBuilder num = new StringBuilder();

				// There may be more than one digit in the number
				while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')){
					num.append(tokens[i++]);
				}
					values.push(Double.parseDouble(num.toString()));

				// correct the offset.
				i--;
			}

			// Current token is an opening brace,
			// push it to 'ops'
			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			// Closing brace encountered, solve entire brace
			else if (tokens[i] == ')')
			{
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			// Current token is an operator.
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' ||
					tokens[i] == '/' || tokens[i] == '^')
			{
				// While top of 'ops' has same or greater precedence to current operator,
				// apply operator on top of 'ops' to top two elements in values stack
				if (!ops.isEmpty() && values.size() >= 2){
					while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}
				if (ops.size() >= 1 && values.size() < 2){
					falseinput = true;
					return 0;
				}
				// Push current token to 'ops'.
				ops.push(tokens[i]);
			}

			// exp() function
			else if (tokens[i] == 'e' && tokens[++i] == 'x' && tokens[++i] == 'p')
			{
				// skip bracket
				i += 2; 
				
				StringBuilder num = new StringBuilder();
	
				// get all the digits in the number
				while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')){
					num.append(tokens[i++]);
				}
				// get the exp of the number and push it to the stack of values
				values.push(Math.exp(Double.parseDouble(num.toString())));
			}

			// log() function
			else if (tokens[i] == 'l' && tokens[++i] == 'o' && tokens[++i] == 'g')
			{
				i += 2;
				
				StringBuilder num = new StringBuilder();
	
				// get all the digits of the number
				while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')){
					num.append(tokens[i++]);
				}
				// get the log of the number and push it to the stack of values
				values.push(Math.log(Double.parseDouble(num.toString())));
			}
				
			//If the input is none of the above, then it is not valid
			else
			{
				falseinput = true;      
				return 0;

			}
		}

		// Entire expression has been
		// parsed at this point, apply remaining
		// ops to remaining values
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		// Top of 'values' contains
		// result, return it
		return values.pop();
	}



	// Returns true if 'op2' has higher
	// or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(
			char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '^' ) && (op2 == '*' || op2 == '/'))
			return false;
		if ((op1 == '*' ) && (op2 == '+' || op2 == '-'))
			return false;
		if ((op1 == '/' ) && (op2 == '+' || op2 == '-'))
			return false;
		else return true;
	}

	// A utility method to apply an
	// operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static double applyOp(char op, double b, double a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		case '^':
			return (double) Math.pow(a,b);
		}
		return 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == equButton)
		{
			input = textfield.getText();

			exp = input;
			result = evaluate(exp);
			if(falseinput)
			{
				textfield.setText("Invalid input");
			}
			else
			{
				System.out.println(result);
				DecimalFormat df = new DecimalFormat("#.###");
				textfield.setText(df.format(result));
			}

		}
		if(e.getSource()==clrButton)
		{
			textfield.setText("");
		}

	}


}