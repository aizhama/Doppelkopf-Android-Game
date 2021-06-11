/*

    wenn es wäre keinen lamda, dann könnte man es mit Observer und Observable implementieren
   1.Observer 2.ChildObserver extend from Observer
   2.Observable hier sollte man die meth von Child Klassen die Methoden (setChagedValue) aufrufen
   3.In Main von Observable beobachtbar erstellen und
        #setValue("FirstSetValue)
        # beobachtbar.setChagedValue(new ChildObserver());
        ##setValue("FirstSetValue) und ab dem zweiten Änderungen den beobachtbar ubermittelt uns,
                        über zweiten Änderungen



    So wäre es mit Observer anstatt Lamda Funktion
    package interfacenJava;

public interface Observer <T>{
    void onChange(T newValue);
}
class MyObserver_First <T> implements Observer<T> {
    @Override
    public void onChange(T value){
        System.out.println("From MyObserver_First: "+value);
    }

}
class SecondMyObserver <T> implements Observer<T> {
    @Override
    public void onChange(T value){
        System.out.println("Neue Wert_B: "+value);
    }

}

class Observable<T>{
    private T value;
    private Observer<T> chagedValue;

    public void setValue(T value){
        this.value=value;
        if(chagedValue !=null){
            //wenn die chagedValue !=null(von der Child Klassen es wird uberschrieben und wird nicht null)
            // dan darf man den chagedValue aufrufen und die value übergeben
            chagedValue.onChange(value);
        }
    }
    public T getValue(){
        return value;
    }
    public void setChagedValue(Observer<T> lamdaFuncOderChildFunktion){
        chagedValue=lamdaFuncOderChildFunktion;
    }
}

class Main {
    public static void main(String[] args){
        Observable beobachtbar=new Observable();
        beobachtbar.setValue("Die erste A_Value");

        beobachtbar.setChagedValue(new MyObserver_First());
        beobachtbar.setValue("Die zweite B_Value");
    }
}



}*/
