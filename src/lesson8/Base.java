package lesson8;

class Base {
    int baseValue;

    public Base(int baseValue){
        this.baseValue = baseValue;
    }
    @Override
    protected Base clone() throws CloneNotSupportedException{
        return new Base(this.baseValue);
    }

    @Override
    public boolean equals(Object obj) {
        // 모든 상황을 고려해줘야 함. 단 일반적인 상황부터 배제- 보다 추상층..(쉴드 패턴)
        if (obj == null) return false; // null부터 배제하는 것이 가장 안전. null은 언어 전체에서 배제사항.
        if (!(obj instanceof Base)) return false; // 슈퍼 - 서브클래스여야지 형변환을 해 줄 수 있음.
        if (obj.hashCode() == this.hashCode()) return true;
        return this.baseValue == ((Base)obj).baseValue;
    }

    @Override
    public String toString() {
         return "base:"+this.hashCode()+":value=" +this.baseValue;
    }
}
