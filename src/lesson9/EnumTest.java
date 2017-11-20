package lesson9;

public class EnumTest {
    public static class Tshirt {
        private final Size size;

        // 내부 클래스에서 enum할 수 없음, 인스턴스와 연결되야 하므로;
        public enum Size {
            SMALL, MEDIUM, LARGE
        }

        ;


        public Tshirt(Size $size) {
            // $는 해당 인자를 버리겠다는 의미.
            // 인자에는 final 선언이 불가하기 때문에 새로 안에서 파이널로 정의해서 인자는 버림.
            final Size size = $size; // "화이트 리스트" - 믿을 수 있음. 안전.
            this.size = size;
        }

        public boolean isFit(Person target) {
            final int base = target.height / 2;
            switch (this.size) {
                case SMALL:
                    return base < 50;
                case MEDIUM:
                    return base < 70;
            }
            /* 이와 동일한 코드.
            switch (this.size.ordinal()){
                case 0: return target.height / 2 < 50;
            }
            */
            return true;
        }
    }
}
