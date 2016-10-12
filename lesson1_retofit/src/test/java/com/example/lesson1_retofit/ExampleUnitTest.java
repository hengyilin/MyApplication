package com.example.lesson1_retofit;

import android.graphics.Bitmap;
import android.graphics.Interpolator;
import android.graphics.drawable.InsetDrawable;
import android.util.Log;

import com.example.lesson1_retofit.bean.Course;
import com.example.lesson1_retofit.bean.Student;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void flatMapTest(){
        final Student[] students = {};
        Subscriber<Course> subscriber = new Subscriber<Course>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                System.out.println(course.getCourse());
            }
        };

        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from((Iterable<? extends Course>) student.getCourse());
                    }

                })
                .subscribe(subscriber);
    }
    @Test
    public void transfrom(){
        Observable.just("images/logo.png")
                .map(new Func1<String, Bitmap>() {

                    @Override
                    public Bitmap call(String path) {
                        return getBitmapFromPath(path);
                    }
                })
                .subscribe(new Action1<Bitmap>() {


                    @Override
                    public void call(Bitmap bitmap) {
                        showBitMap(bitmap);
                    }
                });
    }

    private void showBitMap(Bitmap bitmap) {


    }

    private Bitmap getBitmapFromPath(String path) {
        return null;
    }

}