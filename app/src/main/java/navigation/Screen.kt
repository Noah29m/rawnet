package navigation

sealed class Screen(val route:String){
    object Dashboard :Screen("Dashboard")
    object CheckOutProductScreen :Screen("Check_Out_Product_Screen")
    object CheckOutScreen :Screen("Check_Out_Screen")
    object PaymentScreen :Screen("Payment_Screen")
    object PopularScreen :Screen("Popular_Screen")
    object ProductDetailScreen :Screen("Product_Detail_Screen")
    object HomeScreen :Screen ("Home_Screen")
}
