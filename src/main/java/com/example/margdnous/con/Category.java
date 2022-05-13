package com.example.margdnous.con;

public enum Category {
    BOOK(1,"book"),
    CANDY(2,"candy"),
    CEREAL(3,"cereal"),
    CHIPS(4,"chips"),
    CLEANING(5,"cleaning"),
    CRACKER(6,"cracker"),
    CRAFT(7,"craft"),
    DRINK(8,"drink"),
    FOOTWARE(9,"footware"),
    HYGIENE(10,"hygiene"),
    LOTION(11,"lotion"),
    PASTA(12,"pasta"),
    PEST(13,"pest"),
    PORRIDGE(14,"porridge"),
    SEASONING(15,"seasoning"),
    SNACK(16,"snack"),
    SOUP(17,"soup"),
    STORAGE(18,"storage"),
    TOILETRY(19,"toiletry"),
    TOY(20,"toy"),
    UTENSIL(21,"utensil"),
    VITAMIN(22,"vitamin");
    private int idx;
    private String name;
    Category(int i,String s) {
        this.idx = i;
        this.name = s;
    }
    public int find(String s){
        if(this.name.equals(s)){
            return this.idx;
        }
        return -1;
    }
}
