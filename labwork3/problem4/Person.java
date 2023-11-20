package labwork3.problem4;

abstract class Person {
    public String name;
    public Person(){}
    public Person(String name){
        this.name=name;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Person p = (Person)o;
        return this.name.equals(p.name);
    }
    public String toString() {
        return this.name;
    }
}
