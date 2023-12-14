import controller.SupplierController;
import domain.DTO.SupplierRequest;
import domain.DTO.SupplierResponse;

public class AppSmartCut {

    public static void main(String[] args) {

        //PRUEBAS PARA EL CRUD

        SupplierController supplierController = new SupplierController();
     /*   supplierController.create(
                new SupplierRequest("Victor",
                        "Agudelo",
                        "1116268868",
                        "3186360926",
                        "Cra 28a",
                        "Es una prueba"));



        supplierController.getAll().forEach(supplier->{
            System.out.println(
                    supplier.firstName()+" "+
                    supplier.lastName()+" "+
                    supplier.cedula()+" "+
                    supplier.phone()+" "+
                    supplier.addres()+" "+
                    supplier.description()+" "+
                    supplier.dataRegister()
            );
        });

        supplierController.delete(1L);
 */
        SupplierResponse supplier = supplierController.getById(1L);

       try {
           System.out.println(
                   supplier.firstName()+" "+
                           supplier.lastName()+" "+
                           supplier.cedula()+" "+
                           supplier.phone()+" "+
                           supplier.addres()+" "+
                           supplier.description()+" "+
                           supplier.dataRegister()
           );
       }catch (NullPointerException e) {
           System.out.println("no pudo ser encontrado");
       }
    }
}
