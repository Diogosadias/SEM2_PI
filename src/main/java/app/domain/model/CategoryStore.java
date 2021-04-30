package app.domain.model;

import java.util.ArrayList;

public class CategoryStore{

    private ArrayList<Category> categoryList;

    public CategoryStore(){
        categoryList = new ArrayList<>();
    }

    public void addCategory(Category category){
        categoryList.add(category);
    }

    public void write(){
        for(Category n : categoryList)
            System.out.println("Name:"+n.getName()+" Code:"+n.getCode());
    }

}
