package hemiy.qinghui.com.mytestdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 使用了插件生成序列化的实体
 * Created by hemiy on 16/6/11.
 */
public class Book implements Parcelable {

    private String date;
    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.date = in.readString();
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
