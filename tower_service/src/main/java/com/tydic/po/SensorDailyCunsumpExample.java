package com.tydic.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SensorDailyCunsumpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SensorDailyCunsumpExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andNodecodeIsNull() {
            addCriterion("NodeCode is null");
            return (Criteria) this;
        }

        public Criteria andNodecodeIsNotNull() {
            addCriterion("NodeCode is not null");
            return (Criteria) this;
        }

        public Criteria andNodecodeEqualTo(String value) {
            addCriterion("NodeCode =", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotEqualTo(String value) {
            addCriterion("NodeCode <>", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThan(String value) {
            addCriterion("NodeCode >", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThanOrEqualTo(String value) {
            addCriterion("NodeCode >=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThan(String value) {
            addCriterion("NodeCode <", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThanOrEqualTo(String value) {
            addCriterion("NodeCode <=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLike(String value) {
            addCriterion("NodeCode like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotLike(String value) {
            addCriterion("NodeCode not like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeIn(List<String> values) {
            addCriterion("NodeCode in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotIn(List<String> values) {
            addCriterion("NodeCode not in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeBetween(String value1, String value2) {
            addCriterion("NodeCode between", value1, value2, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotBetween(String value1, String value2) {
            addCriterion("NodeCode not between", value1, value2, "nodecode");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSensornameIsNull() {
            addCriterion("SensorName is null");
            return (Criteria) this;
        }

        public Criteria andSensornameIsNotNull() {
            addCriterion("SensorName is not null");
            return (Criteria) this;
        }

        public Criteria andSensornameEqualTo(String value) {
            addCriterion("SensorName =", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotEqualTo(String value) {
            addCriterion("SensorName <>", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameGreaterThan(String value) {
            addCriterion("SensorName >", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameGreaterThanOrEqualTo(String value) {
            addCriterion("SensorName >=", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameLessThan(String value) {
            addCriterion("SensorName <", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameLessThanOrEqualTo(String value) {
            addCriterion("SensorName <=", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameLike(String value) {
            addCriterion("SensorName like", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotLike(String value) {
            addCriterion("SensorName not like", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameIn(List<String> values) {
            addCriterion("SensorName in", values, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotIn(List<String> values) {
            addCriterion("SensorName not in", values, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameBetween(String value1, String value2) {
            addCriterion("SensorName between", value1, value2, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotBetween(String value1, String value2) {
            addCriterion("SensorName not between", value1, value2, "sensorname");
            return (Criteria) this;
        }

        public Criteria andChargedayIsNull() {
            addCriterion("ChargeDay is null");
            return (Criteria) this;
        }

        public Criteria andChargedayIsNotNull() {
            addCriterion("ChargeDay is not null");
            return (Criteria) this;
        }

        public Criteria andChargedayEqualTo(Date value) {
            addCriterionForJDBCDate("ChargeDay =", value, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayNotEqualTo(Date value) {
            addCriterionForJDBCDate("ChargeDay <>", value, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayGreaterThan(Date value) {
            addCriterionForJDBCDate("ChargeDay >", value, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ChargeDay >=", value, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayLessThan(Date value) {
            addCriterionForJDBCDate("ChargeDay <", value, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ChargeDay <=", value, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayIn(List<Date> values) {
            addCriterionForJDBCDate("ChargeDay in", values, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayNotIn(List<Date> values) {
            addCriterionForJDBCDate("ChargeDay not in", values, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ChargeDay between", value1, value2, "chargeday");
            return (Criteria) this;
        }

        public Criteria andChargedayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ChargeDay not between", value1, value2, "chargeday");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridIsNull() {
            addCriterion("TelOperatorID is null");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridIsNotNull() {
            addCriterion("TelOperatorID is not null");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridEqualTo(Integer value) {
            addCriterion("TelOperatorID =", value, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridNotEqualTo(Integer value) {
            addCriterion("TelOperatorID <>", value, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridGreaterThan(Integer value) {
            addCriterion("TelOperatorID >", value, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("TelOperatorID >=", value, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridLessThan(Integer value) {
            addCriterion("TelOperatorID <", value, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridLessThanOrEqualTo(Integer value) {
            addCriterion("TelOperatorID <=", value, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridIn(List<Integer> values) {
            addCriterion("TelOperatorID in", values, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridNotIn(List<Integer> values) {
            addCriterion("TelOperatorID not in", values, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridBetween(Integer value1, Integer value2) {
            addCriterion("TelOperatorID between", value1, value2, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andTeloperatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("TelOperatorID not between", value1, value2, "teloperatorid");
            return (Criteria) this;
        }

        public Criteria andElcunsumpIsNull() {
            addCriterion("ElCunsump is null");
            return (Criteria) this;
        }

        public Criteria andElcunsumpIsNotNull() {
            addCriterion("ElCunsump is not null");
            return (Criteria) this;
        }

        public Criteria andElcunsumpEqualTo(Float value) {
            addCriterion("ElCunsump =", value, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpNotEqualTo(Float value) {
            addCriterion("ElCunsump <>", value, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpGreaterThan(Float value) {
            addCriterion("ElCunsump >", value, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpGreaterThanOrEqualTo(Float value) {
            addCriterion("ElCunsump >=", value, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpLessThan(Float value) {
            addCriterion("ElCunsump <", value, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpLessThanOrEqualTo(Float value) {
            addCriterion("ElCunsump <=", value, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpIn(List<Float> values) {
            addCriterion("ElCunsump in", values, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpNotIn(List<Float> values) {
            addCriterion("ElCunsump not in", values, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpBetween(Float value1, Float value2) {
            addCriterion("ElCunsump between", value1, value2, "elcunsump");
            return (Criteria) this;
        }

        public Criteria andElcunsumpNotBetween(Float value1, Float value2) {
            addCriterion("ElCunsump not between", value1, value2, "elcunsump");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}