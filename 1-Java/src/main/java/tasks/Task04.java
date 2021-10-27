package tasks;

/**
 * Реализовать трехмерный вектор.
 * Условие: https://habr.com/ru/post/440436/#20
 * Там есть решение. Сначала попробуйте самостоятельно.
 */
class Vector {
    public final double x;
    public final double y;
    public final double z;

    private final double eps = 1e-9;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double Length() {
        return Math.hypot(x, Math.hypot(y, z));
    }

    public double Dot(Vector a) {
        return x * a.x + y * a.y + z * a.z;
    }

    public Vector Cross(Vector a) {
        return new Vector(y * a.z + z * a.y, z * a.x + x * a.z, x * a.y - y * a.x);
    }

    public double AngleCos(Vector a) {
        final double len = Length();
        final double a_len = a.Length();

        if (len < eps || a_len < eps) {
            return 1;
        }

        return Dot(a) / (Length() * a.Length());
    }

    public Vector Plus(Vector a) {
        return new Vector(x + a.x, y + a.y, z + a.z);
    }

    public Vector Minus(Vector a) {
        return new Vector(x - a.x, y - a.y, z - a.z);
    }

    public static Vector[] GetRandomVectorArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("size must be >= 0");
        }

        Vector[] arr = new Vector[size];

        for (int i = 0; i < size; ++i) {
            arr[i] = new Vector(Math.random(), Math.random(), Math.random());
        }

        return arr;
    }
}

public class Task04 {

}
