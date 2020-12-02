public class ThreeSixNineGame {

    public static void main(String[] args) {
    	int i = 1;

        for(i=1; i <= 100; i++) { // TODO i가 1부터 100까지 반복되어야합니다.
        	System.out.println("["+i+"]");
        	boolean is369 = i%10 == 3 || i%10== 6 || i%10 == 9; // TODO 숫자의 1의 자리수가 3, 6, 9 에 해당 되는지 확인해주세요        
            System.out.println("1의자리 : "+is369);
            boolean is306090 = i/10 == 3 || i/10== 6 || i/10 == 9; // TODO 숫자의 10의 자리수가 3, 6, 9 에 해당 되는지 확인해주세요
            System.out.println("10의자리 : "+is306090);
            int firstNumber = i%10; // TODO 1의 자리 숫자를 나타냅니다
            int secondNumber = i/10;  // TODO 10의 자리 숫자를 나타냅니다.
            

            
            	if(firstNumber == 3 || firstNumber == 6 || firstNumber == 9) {
            		if(secondNumber == 3 || secondNumber == 6 || secondNumber == 9) {
            			System.out.println("결과>"+"** "+"\n");
            			continue;
            		}
            		System.out.println("결과>"+"* "+"\n");
            	}
            	else if(secondNumber == 3 || secondNumber == 6 || secondNumber == 9) {
        			System.out.println("결과>"+"* "+"\n");
        		}            	
            	
            	else System.out.println("결과>"+i+" "+"\n");
        	
            // TODO 숫자가 33, 36, 39, 63, 66, 69, 93, 96, 99에 해당되는 경우 '**'이 출력됩니다. System.out.println("**")
            // TODO 숫자에 3, 6, 9가 한번 포함되는 경우 '*'이 출력됩니다. System.out.println("*")

        }
    }
}
