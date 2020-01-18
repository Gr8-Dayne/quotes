package quotes;

public class Quote {

     String text;
     String author;
     String starWarsQuote;
     int id;

    public Quote(String text, String author, String starWarsQuote, int id) {
        this.text = text;
        this.author = author;
        this.starWarsQuote = starWarsQuote;
        this.id = id;
    }

    public void starWarsQuote(int id, String starWarsQuote) {
        this.id = id;
        this.starWarsQuote = starWarsQuote;
    }

}



//public class Cat {
//    String name;
//    boolean sharpClaws;
//    String color;
//    String favoriteFood;
//    int hairLengthInCm;
//
//    public Cat(String name, boolean sharpClaws, String color, String favoriteFood, int hairLengthInCm) {
//        this.name = name;
//        this.sharpClaws = sharpClaws;
//        this.color = color;
//        this.favoriteFood = favoriteFood;
//        this.hairLengthInCm = hairLengthInCm;
//    }
//
//    public void sneak(){
//        if(this.sharpClaws == false){
//            System.out.println("sneak sneak sneak sneak");
//        } else {
//            System.out.println("click click click click");
//        }
//    }
//}


