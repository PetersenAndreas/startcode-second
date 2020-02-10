/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.MovieFacade;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;
/**
 *
 * @author andre
 */
public class MakeTestData {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/Movie",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    
    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    
    private static final MovieFacade mf =  MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
 
    public static void main(String[] args) {
        
        Movie movie1 = new Movie(1987, "Yepper", new String[]{"Henning, Kurt"});
        Movie movie2 = new Movie(1999, "Goodie", new String[]{"Ryan"});
        Movie movie3 = new Movie(2020, "HeyHey", new String[]{"Nina, Knud, Bjarne"});
        mf.addMovie(movie1);
        mf.addMovie(movie2);
        mf.addMovie(movie3);
        
    }
}
