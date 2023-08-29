public enum rim {
    I(1,"I"), II(2,"II"), III(3,"III"), IV(4,"IV"),V(5,"V"),VI(6,"VI"), VII(7,"VII"), VIII(8,"VIII"), IX(9,"IX"), X(10,"X");
    private Integer value;
    private  String icon;
    rim(Integer value,String icon){
        this.value=value;
        this.icon=icon;
    }
    public Integer getValue(){
                return value;
    }
    public String getIcon(){
        return icon;
    }
}
