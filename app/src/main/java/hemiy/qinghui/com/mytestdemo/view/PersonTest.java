package hemiy.qinghui.com.mytestdemo.view;

/**
 * 变种的builder模式,用了一个as的插件
 * http://www.jianshu.com/p/1ddb69f1f67e
 * Created by hemiy on 17/1/24 15:44.
 */

public class PersonTest {
    private final String mName;
    private int mAge;
    private String mLocation;

    private PersonTest(Builder builder) {
        mName = builder.mName;
        mAge = builder.mAge;
        mLocation = builder.mLocation;
    }

    public static final class Builder {
        private String mName;
        private int mAge;
        private String mLocation;

        public Builder() {
        }

        public Builder mName(String mName) {
            this.mName = mName;
            return this;
        }

        public Builder mAge(int mAge) {
            this.mAge = mAge;
            return this;
        }

        public Builder mLocation(String mLocation) {
            this.mLocation = mLocation;
            return this;
        }

        public PersonTest build() {
            return new PersonTest(this);
        }
    }
}
