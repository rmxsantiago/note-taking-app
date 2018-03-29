package ie.rmxsantiago.notetaking.model.pojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rmxsantiago on 28/03/2018.
 */

public class Note implements Parcelable{
    private String title;
    private String text;
    private Category category;

    public Note(String title, String text, Category category) {
        this.title = title;
        this.text = text;
        this.category = category;
    }

    public Note() {
    }

    protected Note(Parcel in) {
        title = in.readString();
        text = in.readString();
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(text);
        parcel.writeParcelable(category, i);
    }
}
