import java.util.ArrayList;
import javax.swing.*;


public class LoveCalculator{
    public static void calculateLove(String nameGirl, String nameBoy, JLabel Label ){

        nameGirl = nameGirl.toLowerCase();
        nameBoy = nameBoy.toLowerCase();


        String bothNames = nameGirl + nameBoy;

        char[] nameArray = bothNames.toCharArray();

        int count  = 1;

        ArrayList<Integer>numbName = new ArrayList<>();

        for(int i = 0; i<nameArray.length; i++){
            if(nameArray[i]=='\0'){
                continue;
            }
            for(int j = i + 1; j<nameArray.length; j++){
                if(nameArray[i]==nameArray[j]){
                    count++;
                    nameArray[j] = '\0';
                }
            }
            numbName.add(count);
            count = 1;
        }
        ArrayList<Integer>newArray = numbName;

        do{
        newArray = newNumbName(newArray);
        }while(newArray.size()>2 );
        


         // Събираме резултата в String
         StringBuilder result = new StringBuilder();
         for(int i : newArray){
            result.append(i);
         }

        // Поставяме резултата в JLabel
        Label.setText(result.toString());
        Label.revalidate();  // Опресняваме графичния интерфейс
        Label.repaint();     // Принуждаваме да се прерисува
        

    }
    public static ArrayList<Integer>newNumbName (ArrayList<Integer> numbName){
        ArrayList<Integer>newArray = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i<numbName.size()/2; i++){
            sum = numbName.get(i) + numbName.get(numbName.size()-i-1);
            newArray.add(sum);
        }
        if(numbName.size()%2 !=0){
            newArray.add(numbName.get(numbName.size()/2));
        }
        return  newArray;
    }
}