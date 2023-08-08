/*
Дано предложение: "Казнить нельзя помиловать".
Поменяйте первое и последнее слово в нем местами;
добавьте в него запятую на нужном месте и выведите на печать.
 */
public class Main {
    public static void main(String[] args) {
        String text = "Казнить нельзя помиловать";
        System.out.println(text);

        String[] words = text.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String middleText = text.substring(firstWord.length() + 1, text.length() - lastWord.length() - 1);

        String modifiedText = lastWord + " " + middleText + " " + firstWord;
        String modifiedText1 = modifiedText.replace("нельзя", "нельзя,");
        String modifiedText2 = modifiedText.replace("помиловать", "помиловать,");

        System.out.println(modifiedText1);
        System.out.println(modifiedText2);
    }
}
