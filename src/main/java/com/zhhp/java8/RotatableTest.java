package com.zhhp.java8;

public class RotatableTest {

    interface Rotatable{
        void setRotationAngle(int angleInDegrees);
        int getRotationAngle();

        default void rotateBy(int angleInDegrees){
            setRotationAngle((getRotationAngle() + angleInDegrees) % 360);
        }
    }

    interface Moveable{
        int getX();
        int getY();
        void setX(int x);
        void setY(int y);

        default void moveHorizontally(int distance){
            setX(getX()+distance);
        }

        default void moveVertically(int distance){
            setX(getY()+distance);
        }
    }

    interface Resizeable{
        int getWidth();
        int getHeight();
        void setWidth(int width);
        void setHeight(int height);

        void setAbsoluteSize(int width,int height);
        default void setRelativeSize(int wFactor,int hFactor){
            setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
        }
    }

    class Monster implements Rotatable,Moveable,Resizeable{

        @Override
        public void setRotationAngle(int angleInDegrees) {

        }

        @Override
        public int getRotationAngle() {
            return 0;
        }

        @Override
        public int getX() {
            return 0;
        }

        @Override
        public int getY() {
            return 0;
        }

        @Override
        public void setX(int x) {

        }

        @Override
        public void setY(int y) {

        }

        @Override
        public int getWidth() {
            return 0;
        }

        @Override
        public int getHeight() {
            return 0;
        }

        @Override
        public void setWidth(int width) {

        }

        @Override
        public void setHeight(int height) {

        }

        @Override
        public void setAbsoluteSize(int width, int height) {

        }
    }

    public void test(){
        Monster m = new Monster();
    }
}
