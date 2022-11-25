package test;

class more {
    String str="test";
    more(){}

    more first(){
        return this;
    }
    more second(){
        return new more();
    }
}
