package com.imooc.proxy.one;

/**
 * 代理主题类
 * 成员变量bFill是布尔变量，当执行itemFill()时，有初始bFill是false,因此调用一次具体的主题类的，item.itemFill(),完成对content\plan字段数据的填充，最后把bFill置成true.也就是说，无论调用代理对象itemFill()多少次，由于bFill布尔变量的作用，都只执行具体主题类对象的itemFill()方法一次
 * 由于第一级一个大范围的查询，因此一定是ProxyItem的集合，因此一个是ProxyItem的集合，这就是下面描述的ManageItems类
 */
public class Proxyitem implements IITem {
    private RealITem item;
    boolean bFill;//标识、plan字段是否填充

    public Proxyitem(RealITem item) {
        this.item = item;
    }

    @Override
    public String getAccount() {
        return item.getAccount();
    }

    @Override
    public void setAccount(String s) {
        item.setAccount(s);
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public void setName(String s) {
        item.setName(s);
    }

    @Override
    public String getProject() {
        return item.getProject();
    }

    @Override
    public void setProject(String s) {
        item.setProject(s);
    }

    @Override
    public String getContent() {
        return item.getContent();
    }

    @Override
    public String getPlan() {
        return item.getPlan();
    }

    @Override
    public void itemFill() throws Exception {
        if(!bFill){
            item.itemFill();
            bFill=true;
        }
    }
}
