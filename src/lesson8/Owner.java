package lesson8;

// 공개될 필요(얼만큼 보여주냐)가 없다면 가시성을 낮출것 - 간섭받을 가능성이 줄어듦!!
// 항상 보수적으로 만듦. 필요하면 보여줌 -- 변수의 원칙도 마찬가지. 일단 final!.
// 그러나 메서드나 클래스에는 반대! final을 걸면 상속이나 오버라이드가 안 됨.
// 메서드나 클래스는 상속이나 오버라이드의 가능성을 열어둚 - 점진적인 확장 구현을 생각함!(디커플링-인터페이스 혹은 추상 클래스)
// 택배기사 ----------------사이트 --------------------여러분(112)
//      X27 <---------------                 (디커플링)
//      X27 ----------------> 교환소 --(임플리먼트)--> 여러분(115) (변경되어도 상관 없음)
class Owner {
    private final int OwnerValue;
    private final Base ownerBase;

    Owner(int ownerValue, Base ownerBase) {
        this.OwnerValue = ownerValue;
        this.ownerBase = ownerBase;
    }

    @Override
    // 메서드에 throws 선언을 하면 밖에서는 try/catch를 걸지 않으면 사용할 수 없음
    protected Owner clone() throws CloneNotSupportedException {
        // 얕은 복사
        Owner result = new Owner(this.OwnerValue, this.ownerBase);

        // 깊은 복사 - clone을 호출하면 clone을 호출함 - 컴퍼런트 패턴?
        // 오너는 오너만 신경 쓰고, 하위 구성요소에 대한 책임은 하위 구성요소가 맡음.(하위 위임)
        // 단일 책임 원칙!
        result = new Owner(this.OwnerValue, this.ownerBase.clone());

        return result;
    }

    public Base getBase() {
        return ownerBase;
    }
}
