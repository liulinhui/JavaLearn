package learn;
public class InnerClass {  
    private String label="�Ϸ�";  
    class Destination{  
        private String label;  
        Destination(String whereTo){  
            label=whereTo;  
        }  
        String readFatherLabel(){  
            return InnerClass.this.label;//����.this�൱�� �����е�this  
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
        private String label="��̬�ڲ��಻��Ҫ�ڲ�����ⲿ����������";  
        public String getLabel(){  
            return label;  
        };  
    }  
  
    public static void main(String [] args){  
    	InnerClass test=new InnerClass();  
        test.ship("����");  
        InnerClass test1=new InnerClass();  
        InnerClass.Destination dest=test1.getDest("�Ϻ�");  
        Destination dest1=test1.getDest("�Ͼ�");  
        System.out.println(dest.readLabel());  
        System.out.println(dest1.readFatherLabel());  
        Context c=new Context();  
        System.out.println(c.getLabel());  
  
          
    }  
  
}  