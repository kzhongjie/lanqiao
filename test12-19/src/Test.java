import com.sun.org.apache.xpath.internal.operations.Or;

public class Test {
    public static void main(String[] args){
        //创建客户
        Customer customer = new Customer();
        customer.customerName = "张三";
        customer.address="桂林电子科技大学";
        customer.phone="14877456283";

        //创建商品
        Commodity commodity=new Commodity();
        commodity.name="云南白药";
        //创建订单
        Order order= new Order();
        order.orderId="00038471";
        order.price=66;
        order.orderContent="云南白药";

        //创建客户与订单的关联
        customer.order=order;
        order.customer=customer;

        System.out.println("订单的金额："+customer.order.price);
    }
}
