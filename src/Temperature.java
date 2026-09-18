public record Temperature(double celsius) {
    public Temperature {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("абсолютный ноль — ниже физически невозможно.");
        }
    }

    public double toFahrenheit() {
        return celsius * 9.0 / 5.0 + 32.0;
    }
}
