package ru.mishkin.lab5;
import java.io.*;
import java.util.*;

abstract class Body implements Square, Volume{
        public int id;
        public String name;
        public int x,y,z;
        public String square;
        public String volume;
     
        
        
        void print(){
            System.out.printf("id-%-3s x:%-3s y:%-3s Фигура: %-15s Площадь: %-2s Объем: %-4s\n",Integer.toString(id),Integer.toString(x),Integer.toString(y),name,square,volume);
        }
  
}
    class Cube extends Body {
        Cube(int id1, int x1)
        {
            id = id1;
            x=x1;
            y = 0;
            name = "Куб";
            square = null;
            volume = null;
        }

        @Override
        public String toString() 
        {
            return String.format("id-%-3s Фигура: %-15s H:%-3s\n",
                    Integer.toString(id),name,Integer.toString(x));
        }
        
        void print()
        {
            System.out.print(toString());
        }

    @Override
    public String square() {
        square = Integer.toString(x*x*6);
        System.out.printf("id-%-3s Фигура: %-15s square:%-3s\n",
                    Integer.toString(id),name,square);
        return square;
    }

    @Override
    public String volume() {
        volume = Integer.toString(x*x*x);
            System.out.printf("id-%-3s Фигура: %-15s volume:%-3s\n",
                    Integer.toString(id),name,volume);
        return volume;
    }
    }
    class Tetraider extends Body {
        Tetraider(int id1, int A)
        {
            id = id1;
            x=A;
            name = "Тетраэдр";
            square = null;
            volume = null;
        }

        @Override
        public String toString() 
        {
            return String.format("id-%-3s Фигура: %-15s A:%-3s\n",
                    Integer.toString(id),name,Integer.toString(x));
        }
        void print()
        {
            System.out.print(toString());
        }
            @Override
        public String square() {
             square = Double.toString(x*x*Math.sqrt(3));
            System.out.printf("id-%-3s Фигура: %-15s square:%-3s\n",
                    Integer.toString(id),name,square);
             
             return square;
        }

        @Override
        public String volume() {
            volume = Double.toString(x*x*x*Math.sqrt(2)/12);
            System.out.printf("id-%-3s Фигура: %-15s volume:%-3s\n",
                    Integer.toString(id),name,volume);
            return volume;
        }
    }

    class Cylinder extends Body {
        
        Cylinder(int id1, int H, int R)
        {
            id = id1;
            x=H;
            y=R;
            name = "Цилиндр";
            square = null;
            volume = null;
            
        }

        @Override
        public String toString() 
        {
            return String.format("id-%-3s Фигура: %-15s H:%-3s R:%-3s\n",
                    Integer.toString(id),name,Integer.toString(x),Integer.toString(y));
        }
        
        void print(){
            System.out.print(toString());
        } 
            @Override
        public String square() {
            square = Double.toString(2*x*y*Math.PI + 2*y*y*Math.PI);
            System.out.printf("id-%-3s Фигура: %-15s square:%-3s\n",
                    Integer.toString(id),name,square);
            return square;
        }

        @Override
        public String volume() {
            volume = Double.toString(y*y*x*Math.PI);
            System.out.printf("id-%-3s Фигура: %-15s volume:%-3s\n",
                    Integer.toString(id),name,volume);
            return volume;
        }
    }


    class Ball extends Body {
        Ball(int id1, int R)
        {
            id = id1;
            y=R;
            name = "Шар";
            square = null;
            volume = null;
        }

        @Override
        public String toString() 
        {
            return String.format("id-%-3s Фигура: %-15s R:%-3s\n",
                    Integer.toString(id),name,Integer.toString(y));
        }
        
        void print()
        {
            System.out.print(toString());
        } 
            @Override
        public String square() {
            square = Double.toString(4*y*y*Math.PI);
         System.out.printf("id-%-3s Фигура: %-15s square:%-3s\n",
                    Integer.toString(id),name,square);
           return square;
        }

        @Override
        public String volume() {
            volume = Double.toString(4/3*y*y*y*Math.PI);
            System.out.printf("id-%-3s Фигура: %-15s volume:%-3s\n",
                    Integer.toString(id),name,volume);
            return volume;
        }
    }

public class laba5 {
    public static int key = -1;
    public static Body test = null;
    public static List<Body> baze = new ArrayList<Body>();
    
    public static void main(String[] args) throws IOException {
      
        
        while(key!=0)
        {
            System.out.println(" 1 - Создать Куб");
            System.out.println(" 2 - Создать Тетраэдр");
            System.out.println(" 3 - Создать Цилиндр");
            System.out.println(" 4 - Создать Шар");
            System.out.println(" 5 - Вывод списка с детальной информацией");
            System.out.println(" 6 - Сортировка по id");
            System.out.println(" 7 - Сортировка по первому параметру размеров");
            System.out.println(" 8 - Сортировка по имени");
            System.out.println(" 9 - Вывод списка при помощи интератора");
            System.out.println("10 - Расчет объема");
            System.out.println("11 - Расчет площади");
            System.out.println("12 - Удаление по индексу");
            System.out.println("0 - Выход");
            InputStreamReader isr = new InputStreamReader(System.in); 
            BufferedReader br = new BufferedReader(isr); 

            Scanner in = new Scanner(System.in);
            key = in.nextInt();
            switch(key)
            {
                case 1:
                    System.out.println("Введите id: ");
                    int id = in.nextInt();
                    System.out.println("Введите H: ");
                    int H = in.nextInt();
                    String name = "Куб";
                    chooseIndex(new Cube(id,H));
                    
                    
                    break;
                case 2:
                    System.out.println("Введите id: ");
                    id = in.nextInt();
                    System.out.println("Введите H: ");
                    int A = in.nextInt();
                    name = "Тетраэдр";
                    chooseIndex(new Tetraider(id,A));
                    
                
                    break;
                case 4:
                    System.out.println("Введите id: ");
                    id = in.nextInt();
                    name = "Шар";
                    System.out.println("Введите R: ");
                    int R = in.nextInt();
                    chooseIndex(new Ball(id,R));

                   
                    break;                
                case 3:
                    System.out.println("Введите id: ");
                    id = in.nextInt();
                    name = "Цилиндр";
                    System.out.println("Введите H: ");
                    H = in.nextInt();
                    System.out.println("Введите R: ");
                    R = in.nextInt();
                    chooseIndex(new Cylinder(id, H, R));
                    
                    break;

               case 5:
                   
                   //Iterator it = baze.iterator();
                  // int k = 1;
                   for(Body test: baze)
                   { 
                      test.print();
                   }
                  /* while (it.hasNext())
                   {
                       test = (Body) it.next();
                       System.out.print(k+": ");
                       test.print();
                       k++;
                   }*/
                   
                   break;
              case 6:
                  Collections.sort(baze,new SortMode(1));
                  for(Body test: baze)
                   { 
                      test.print();
                   }
                  break;
              case 7:
                  Collections.sort(baze,new SortMode(2));
                  for(Body test: baze)
                   { 
                      test.print();
                   }
                  break;
              case 8:
                  Collections.sort(baze,new SortMode(3));
                  for(Body test: baze)
                   { 
                      test.print();
                   }
                  break;
              case 9:
                   
                   Iterator it = baze.iterator();
                   int k = 0;   
                   while (it.hasNext())
                   {
                       test = (Body) it.next();
                       System.out.print(k+": ");
                       test.print();
                       k++;
                   }
                   break;
              case 10:
                  Collections.sort(baze,new SortMode(3));
                  for(Body test: baze)
                   { 
                      test.volume();
                   }
                  break;            
              case 11:
                  Collections.sort(baze,new SortMode(3));
                  for(Body test: baze)
                   { 
                      test.square();
                   }
                  break;  
              case 12:
                  deleteObject();
                  
            }
        }
    }

    private static void chooseIndex(Body body) {
       int index = 0;
       System.out.println("Выберите индекс добавления: ");
       Scanner in = new Scanner(System.in);
       index = in.nextInt();
       try
       {
            baze.add(index, body);
       }catch (IndexOutOfBoundsException e){
           System.out.println("Выбран неуществующий индекс! Добавлен с индексом по умолчанию");
           baze.add(body);
       }
        
    }

    private static void deleteObject() {
       int index = 0;
       System.out.println("Выберите индекс для удаления: ");
       Scanner in = new Scanner(System.in);
       index = in.nextInt();
       try
       {
            baze.remove(index);
            System.out.println("Элемент успешно удален!");
       }catch (IndexOutOfBoundsException e){
           System.out.println("Выбран неуществующий индекс!");
           
       }
    }
}
