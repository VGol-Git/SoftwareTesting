package main.java.ru.miet.testing;
import java.lang.ArithmeticException;
public class SimpleCalcPresenter implements CalculatorPresenter{

    private final SimpleCalc simpleCalc;
    private final CalculatorView calcView;
    private double firstSize;
    private double secondSize;
    public SimpleCalcPresenter(CalculatorView calcView){
        this.calcView = calcView;
        simpleCalc = new SimpleCalc();

    }

    private void prepareSizes(Character operation) {
        try {
            firstSize = Double.parseDouble(calcView.getFirstArgumentAsString());
            secondSize = Double.parseDouble(calcView.getSecondArgumentAsString());
            if (operation.equals('/') && Math.abs(secondSize) <= 1e-8){
                throw new ArithmeticException();
            }
        } catch (NumberFormatException e) {
            calcView.displayError("Wrong number inputted");
            return;
        } catch (NullPointerException e) {
            calcView.displayError("Input a number");
            return;
        } catch(ArithmeticException e) {
            calcView.displayError("You can't divide by zero");
            return;
        }


    }
    @Override
    public void onPlusClicked() {
        prepareSizes('+');
        calcView.printResult(simpleCalc.sum(firstSize, secondSize));
    }

    @Override
    public void onMinusClicked() {
        prepareSizes('-');
        calcView.printResult(simpleCalc.subtract(firstSize, secondSize));

    }

    @Override
    public void onDivideClicked() {
        prepareSizes('/');
        calcView.printResult(simpleCalc.divide(firstSize, secondSize));

    }

    @Override
    public void onMultiplyClicked() {
        prepareSizes('*');
        calcView.printResult(simpleCalc.multiply(firstSize, secondSize));

    }
}
