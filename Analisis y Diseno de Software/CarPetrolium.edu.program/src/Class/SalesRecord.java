package Class;

public class SalesRecord {
    private String saleType,numVenta;
    private double total;

    public SalesRecord(String saleType, String numVenta, double total) {
        if(saleType == null)
            throw new IllegalArgumentException("TIPO DE VENTA NO REGISTRADA");
        if(numVenta == null)
            throw new IllegalArgumentException("NUMERO DE VENTA PERDIDA");
        if(total == 0)
            throw new IllegalArgumentException("PARECE QUE NO LA COMPRA NO FUE SATISFACTORIA");
        this.saleType = saleType;
        this.numVenta = numVenta;
        this.total = total;
    }

    public String getNumVenta() {
        return numVenta;
    }

    public String getSaleType() {
        return saleType;
    }

    public double getTotal() {
        return total;
    }
    
    
}
