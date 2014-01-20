/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mishkin.lab4;

import java.util.Comparator;

/**
 *
 * @author qw1nz
 */
public class SortMode implements Comparator<Body> {
    private int sortType;
    SortMode(int sortType1)
    {
        sortType = sortType1;
    }

    @Override
    public int compare(Body t1, Body t) {
       int res = 0;
      Body other = (Body) t;
      if (sortType == 1) //по айди
      { if (t1.id > other.id) res = 1;
        if (t1.id < other.id) res = -1;
      }
      if (sortType == 2) //по H
      {   if (t1.x > other.x) res = 1;
        if (t1.x < other.x) res = -1;
      }
      if (sortType == 3) //по name
      {   res = t1.name.compareTo(other.name);}
      return res; 
    }
    
}
