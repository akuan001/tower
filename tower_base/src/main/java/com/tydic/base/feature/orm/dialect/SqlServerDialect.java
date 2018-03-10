package com.tydic.base.feature.orm.dialect;

public class SqlServerDialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return SqlServerPageHepler.getLimitString(sql, offset, limit);
    }

    @Override
    public String getCountString(String sql) {
        return SqlServerPageHepler.getCountString(sql);
    }

    public static void main(String[] args) {
        SqlServerDialect test = new SqlServerDialect();
        String tempStr = test.getLimitString(
                "select a.SensorName, a.ChargeDay, a.TelOperatorID, a.ElCunsump, a.NodeCode, b.name as TelOperatorName, c.NodeName from SG_CurrentDetect.dbo.TB_SensorDailyCunsump a, SG_CurrentDetect.dbo.TB_TelOperator b, SG_CurrentDetect.dbo.TB_Node c where a.TelOperatorID = b.id and a.NodeCode = c.NodeCode and a.ChargeDay  >= '2017-12-09' and a.ChargeDay <='2017-12-11' order by a.ChargeDay desc",
                10, 10);
        System.out.println(tempStr);
    }
}
