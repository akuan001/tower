package com.tydic.base.feature.orm.dialect;

/**
 * @author StarZou
 * @since 2014年5月18日 下午1:33:17
 **/
public class OracleDialect extends Dialect {

    @Override
    public String getLimitString(String sql, int offset, int limit) {
       return OraclePageHepler.getLimitString(sql, offset, limit);
    }

    @Override
    public String getCountString(String sql) {
        return OraclePageHepler.getCountString(sql);
    }
    
    public static void main(String[] args) {
        OracleDialect test = new OracleDialect();
        String tempStr = test.getLimitString("select * from t_carousel_pic", 10, 10);
        System.out.println(tempStr);
    }
}
