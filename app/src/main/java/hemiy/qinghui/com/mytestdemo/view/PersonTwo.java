package hemiy.qinghui.com.mytestdemo.view;

/**
 * Created by hemiy on 17/1/24 15:59.
 */

public class PersonTwo {
    private String name;
    private String age;
    private int id;

    private PersonTwo(Builder builder) {
        name = builder.name;
        age = builder.age;
        id = builder.id;
    }


    public static final class Builder {
        private String name;
        private String age;
        private int id;

        private Builder(String name) {
            this.name = name;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public PersonTwo build() {
            return new PersonTwo(this);
        }
    }
}
