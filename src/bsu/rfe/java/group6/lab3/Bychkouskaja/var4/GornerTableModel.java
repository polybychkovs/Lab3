package bsu.rfe.java.group6.lab3.Bychkouskaja.var4;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel{
    //поля класса
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private Double res = 0.0;
    //конструктор для начальной инициализации
    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }
    public Object getValueAt(int row, int col) {
        // Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step * row;
        if (col == 0) {
            return x;
        } else if (col == 1) {
// Вычисление значения в точке по схеме Горнера
            Double result = 0.0;
            for (int i = 0; i < coefficients.length; i++) {
                result += coefficients[i] * Math.pow(x, coefficients.length - i - 1);
            }
            res=result;
            return result;
        } else {
            return ( (res-res%1)== 0);
        }

    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
// Название 1-го столбца
                return "Значение X";
            case 1:
// Название 2-го столбца
                return "Значение многочлена";
            case 2:
//Название 3-го столбца
                return "Малое число?";
            default:
                throw new IllegalStateException("Unexpected value: " + col);
        }
    }

    public Class<?> getColumnClass(int col) {

        switch (col) {
            case 0:
                return Double.class;
            case 1:
                return Double.class;
            default:
                return Boolean.class;
        }
    }
}
