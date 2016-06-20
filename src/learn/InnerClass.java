package learn;
public class InnerClass {  
    private String label="合肥";  
    class Destination{  
        private String label;  
        Destination(String whereTo){  
            label=whereTo;  
        }  
        String readFatherLabel(){  
            return InnerClass.this.label;//父类.this相当于 父类中的this  
        }  
        String readLabel(){  
            return label;  
        }  
    }  
    public Destination getDest(String label){  
        return new Destination(label);  
    }  
    public void ship(String dest){  
            Destination dest1=new Destination(dest);  
            System.out.println(dest1.label);  
    }  
    static class Context{  
        private String label="静态内部类不需要内部类对外部类对象的引用";  
        public String getLabel(){  
            return label;  
        };  
    }  
  
    public static void main(String [] args){  
    	InnerClass test=new InnerClass();  
        test.ship("北京");  
        InnerClass test1=new InnerClass();  
        InnerClass.Destination dest=test1.getDest("上海");  
        Destination dest1=test1.getDest("南京");  
        System.out.println(dest.readLabel());  
        System.out.println(dest1.readFatherLabel());  
        Context c=new Context();  
        System.out.println(c.getLabel());  
  
          
    }  
  
}  