package com.tydic.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SensorValuesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SensorValuesExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andSensor01IsNull() {
            addCriterion("Sensor01 is null");
            return (Criteria) this;
        }

        public Criteria andSensor01IsNotNull() {
            addCriterion("Sensor01 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor01EqualTo(Float value) {
            addCriterion("Sensor01 =", value, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01NotEqualTo(Float value) {
            addCriterion("Sensor01 <>", value, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01GreaterThan(Float value) {
            addCriterion("Sensor01 >", value, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor01 >=", value, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01LessThan(Float value) {
            addCriterion("Sensor01 <", value, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01LessThanOrEqualTo(Float value) {
            addCriterion("Sensor01 <=", value, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01In(List<Float> values) {
            addCriterion("Sensor01 in", values, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01NotIn(List<Float> values) {
            addCriterion("Sensor01 not in", values, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01Between(Float value1, Float value2) {
            addCriterion("Sensor01 between", value1, value2, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor01NotBetween(Float value1, Float value2) {
            addCriterion("Sensor01 not between", value1, value2, "sensor01");
            return (Criteria) this;
        }

        public Criteria andSensor02IsNull() {
            addCriterion("Sensor02 is null");
            return (Criteria) this;
        }

        public Criteria andSensor02IsNotNull() {
            addCriterion("Sensor02 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor02EqualTo(Float value) {
            addCriterion("Sensor02 =", value, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02NotEqualTo(Float value) {
            addCriterion("Sensor02 <>", value, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02GreaterThan(Float value) {
            addCriterion("Sensor02 >", value, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor02 >=", value, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02LessThan(Float value) {
            addCriterion("Sensor02 <", value, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02LessThanOrEqualTo(Float value) {
            addCriterion("Sensor02 <=", value, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02In(List<Float> values) {
            addCriterion("Sensor02 in", values, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02NotIn(List<Float> values) {
            addCriterion("Sensor02 not in", values, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02Between(Float value1, Float value2) {
            addCriterion("Sensor02 between", value1, value2, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor02NotBetween(Float value1, Float value2) {
            addCriterion("Sensor02 not between", value1, value2, "sensor02");
            return (Criteria) this;
        }

        public Criteria andSensor03IsNull() {
            addCriterion("Sensor03 is null");
            return (Criteria) this;
        }

        public Criteria andSensor03IsNotNull() {
            addCriterion("Sensor03 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor03EqualTo(Float value) {
            addCriterion("Sensor03 =", value, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03NotEqualTo(Float value) {
            addCriterion("Sensor03 <>", value, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03GreaterThan(Float value) {
            addCriterion("Sensor03 >", value, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor03 >=", value, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03LessThan(Float value) {
            addCriterion("Sensor03 <", value, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03LessThanOrEqualTo(Float value) {
            addCriterion("Sensor03 <=", value, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03In(List<Float> values) {
            addCriterion("Sensor03 in", values, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03NotIn(List<Float> values) {
            addCriterion("Sensor03 not in", values, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03Between(Float value1, Float value2) {
            addCriterion("Sensor03 between", value1, value2, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor03NotBetween(Float value1, Float value2) {
            addCriterion("Sensor03 not between", value1, value2, "sensor03");
            return (Criteria) this;
        }

        public Criteria andSensor04IsNull() {
            addCriterion("Sensor04 is null");
            return (Criteria) this;
        }

        public Criteria andSensor04IsNotNull() {
            addCriterion("Sensor04 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor04EqualTo(Float value) {
            addCriterion("Sensor04 =", value, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04NotEqualTo(Float value) {
            addCriterion("Sensor04 <>", value, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04GreaterThan(Float value) {
            addCriterion("Sensor04 >", value, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor04 >=", value, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04LessThan(Float value) {
            addCriterion("Sensor04 <", value, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04LessThanOrEqualTo(Float value) {
            addCriterion("Sensor04 <=", value, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04In(List<Float> values) {
            addCriterion("Sensor04 in", values, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04NotIn(List<Float> values) {
            addCriterion("Sensor04 not in", values, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04Between(Float value1, Float value2) {
            addCriterion("Sensor04 between", value1, value2, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor04NotBetween(Float value1, Float value2) {
            addCriterion("Sensor04 not between", value1, value2, "sensor04");
            return (Criteria) this;
        }

        public Criteria andSensor05IsNull() {
            addCriterion("Sensor05 is null");
            return (Criteria) this;
        }

        public Criteria andSensor05IsNotNull() {
            addCriterion("Sensor05 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor05EqualTo(Float value) {
            addCriterion("Sensor05 =", value, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05NotEqualTo(Float value) {
            addCriterion("Sensor05 <>", value, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05GreaterThan(Float value) {
            addCriterion("Sensor05 >", value, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor05 >=", value, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05LessThan(Float value) {
            addCriterion("Sensor05 <", value, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05LessThanOrEqualTo(Float value) {
            addCriterion("Sensor05 <=", value, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05In(List<Float> values) {
            addCriterion("Sensor05 in", values, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05NotIn(List<Float> values) {
            addCriterion("Sensor05 not in", values, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05Between(Float value1, Float value2) {
            addCriterion("Sensor05 between", value1, value2, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor05NotBetween(Float value1, Float value2) {
            addCriterion("Sensor05 not between", value1, value2, "sensor05");
            return (Criteria) this;
        }

        public Criteria andSensor06IsNull() {
            addCriterion("Sensor06 is null");
            return (Criteria) this;
        }

        public Criteria andSensor06IsNotNull() {
            addCriterion("Sensor06 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor06EqualTo(Float value) {
            addCriterion("Sensor06 =", value, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06NotEqualTo(Float value) {
            addCriterion("Sensor06 <>", value, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06GreaterThan(Float value) {
            addCriterion("Sensor06 >", value, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor06 >=", value, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06LessThan(Float value) {
            addCriterion("Sensor06 <", value, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06LessThanOrEqualTo(Float value) {
            addCriterion("Sensor06 <=", value, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06In(List<Float> values) {
            addCriterion("Sensor06 in", values, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06NotIn(List<Float> values) {
            addCriterion("Sensor06 not in", values, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06Between(Float value1, Float value2) {
            addCriterion("Sensor06 between", value1, value2, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor06NotBetween(Float value1, Float value2) {
            addCriterion("Sensor06 not between", value1, value2, "sensor06");
            return (Criteria) this;
        }

        public Criteria andSensor07IsNull() {
            addCriterion("Sensor07 is null");
            return (Criteria) this;
        }

        public Criteria andSensor07IsNotNull() {
            addCriterion("Sensor07 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor07EqualTo(Float value) {
            addCriterion("Sensor07 =", value, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07NotEqualTo(Float value) {
            addCriterion("Sensor07 <>", value, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07GreaterThan(Float value) {
            addCriterion("Sensor07 >", value, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor07 >=", value, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07LessThan(Float value) {
            addCriterion("Sensor07 <", value, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07LessThanOrEqualTo(Float value) {
            addCriterion("Sensor07 <=", value, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07In(List<Float> values) {
            addCriterion("Sensor07 in", values, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07NotIn(List<Float> values) {
            addCriterion("Sensor07 not in", values, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07Between(Float value1, Float value2) {
            addCriterion("Sensor07 between", value1, value2, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor07NotBetween(Float value1, Float value2) {
            addCriterion("Sensor07 not between", value1, value2, "sensor07");
            return (Criteria) this;
        }

        public Criteria andSensor08IsNull() {
            addCriterion("Sensor08 is null");
            return (Criteria) this;
        }

        public Criteria andSensor08IsNotNull() {
            addCriterion("Sensor08 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor08EqualTo(Float value) {
            addCriterion("Sensor08 =", value, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08NotEqualTo(Float value) {
            addCriterion("Sensor08 <>", value, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08GreaterThan(Float value) {
            addCriterion("Sensor08 >", value, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor08 >=", value, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08LessThan(Float value) {
            addCriterion("Sensor08 <", value, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08LessThanOrEqualTo(Float value) {
            addCriterion("Sensor08 <=", value, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08In(List<Float> values) {
            addCriterion("Sensor08 in", values, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08NotIn(List<Float> values) {
            addCriterion("Sensor08 not in", values, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08Between(Float value1, Float value2) {
            addCriterion("Sensor08 between", value1, value2, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor08NotBetween(Float value1, Float value2) {
            addCriterion("Sensor08 not between", value1, value2, "sensor08");
            return (Criteria) this;
        }

        public Criteria andSensor09IsNull() {
            addCriterion("Sensor09 is null");
            return (Criteria) this;
        }

        public Criteria andSensor09IsNotNull() {
            addCriterion("Sensor09 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor09EqualTo(Float value) {
            addCriterion("Sensor09 =", value, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09NotEqualTo(Float value) {
            addCriterion("Sensor09 <>", value, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09GreaterThan(Float value) {
            addCriterion("Sensor09 >", value, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor09 >=", value, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09LessThan(Float value) {
            addCriterion("Sensor09 <", value, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09LessThanOrEqualTo(Float value) {
            addCriterion("Sensor09 <=", value, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09In(List<Float> values) {
            addCriterion("Sensor09 in", values, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09NotIn(List<Float> values) {
            addCriterion("Sensor09 not in", values, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09Between(Float value1, Float value2) {
            addCriterion("Sensor09 between", value1, value2, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor09NotBetween(Float value1, Float value2) {
            addCriterion("Sensor09 not between", value1, value2, "sensor09");
            return (Criteria) this;
        }

        public Criteria andSensor10IsNull() {
            addCriterion("Sensor10 is null");
            return (Criteria) this;
        }

        public Criteria andSensor10IsNotNull() {
            addCriterion("Sensor10 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor10EqualTo(Float value) {
            addCriterion("Sensor10 =", value, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10NotEqualTo(Float value) {
            addCriterion("Sensor10 <>", value, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10GreaterThan(Float value) {
            addCriterion("Sensor10 >", value, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor10 >=", value, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10LessThan(Float value) {
            addCriterion("Sensor10 <", value, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10LessThanOrEqualTo(Float value) {
            addCriterion("Sensor10 <=", value, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10In(List<Float> values) {
            addCriterion("Sensor10 in", values, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10NotIn(List<Float> values) {
            addCriterion("Sensor10 not in", values, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10Between(Float value1, Float value2) {
            addCriterion("Sensor10 between", value1, value2, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor10NotBetween(Float value1, Float value2) {
            addCriterion("Sensor10 not between", value1, value2, "sensor10");
            return (Criteria) this;
        }

        public Criteria andSensor11IsNull() {
            addCriterion("Sensor11 is null");
            return (Criteria) this;
        }

        public Criteria andSensor11IsNotNull() {
            addCriterion("Sensor11 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor11EqualTo(Float value) {
            addCriterion("Sensor11 =", value, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11NotEqualTo(Float value) {
            addCriterion("Sensor11 <>", value, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11GreaterThan(Float value) {
            addCriterion("Sensor11 >", value, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor11 >=", value, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11LessThan(Float value) {
            addCriterion("Sensor11 <", value, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11LessThanOrEqualTo(Float value) {
            addCriterion("Sensor11 <=", value, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11In(List<Float> values) {
            addCriterion("Sensor11 in", values, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11NotIn(List<Float> values) {
            addCriterion("Sensor11 not in", values, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11Between(Float value1, Float value2) {
            addCriterion("Sensor11 between", value1, value2, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor11NotBetween(Float value1, Float value2) {
            addCriterion("Sensor11 not between", value1, value2, "sensor11");
            return (Criteria) this;
        }

        public Criteria andSensor12IsNull() {
            addCriterion("Sensor12 is null");
            return (Criteria) this;
        }

        public Criteria andSensor12IsNotNull() {
            addCriterion("Sensor12 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor12EqualTo(Float value) {
            addCriterion("Sensor12 =", value, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12NotEqualTo(Float value) {
            addCriterion("Sensor12 <>", value, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12GreaterThan(Float value) {
            addCriterion("Sensor12 >", value, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor12 >=", value, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12LessThan(Float value) {
            addCriterion("Sensor12 <", value, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12LessThanOrEqualTo(Float value) {
            addCriterion("Sensor12 <=", value, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12In(List<Float> values) {
            addCriterion("Sensor12 in", values, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12NotIn(List<Float> values) {
            addCriterion("Sensor12 not in", values, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12Between(Float value1, Float value2) {
            addCriterion("Sensor12 between", value1, value2, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor12NotBetween(Float value1, Float value2) {
            addCriterion("Sensor12 not between", value1, value2, "sensor12");
            return (Criteria) this;
        }

        public Criteria andSensor13IsNull() {
            addCriterion("Sensor13 is null");
            return (Criteria) this;
        }

        public Criteria andSensor13IsNotNull() {
            addCriterion("Sensor13 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor13EqualTo(Float value) {
            addCriterion("Sensor13 =", value, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13NotEqualTo(Float value) {
            addCriterion("Sensor13 <>", value, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13GreaterThan(Float value) {
            addCriterion("Sensor13 >", value, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor13 >=", value, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13LessThan(Float value) {
            addCriterion("Sensor13 <", value, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13LessThanOrEqualTo(Float value) {
            addCriterion("Sensor13 <=", value, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13In(List<Float> values) {
            addCriterion("Sensor13 in", values, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13NotIn(List<Float> values) {
            addCriterion("Sensor13 not in", values, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13Between(Float value1, Float value2) {
            addCriterion("Sensor13 between", value1, value2, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor13NotBetween(Float value1, Float value2) {
            addCriterion("Sensor13 not between", value1, value2, "sensor13");
            return (Criteria) this;
        }

        public Criteria andSensor14IsNull() {
            addCriterion("Sensor14 is null");
            return (Criteria) this;
        }

        public Criteria andSensor14IsNotNull() {
            addCriterion("Sensor14 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor14EqualTo(Float value) {
            addCriterion("Sensor14 =", value, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14NotEqualTo(Float value) {
            addCriterion("Sensor14 <>", value, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14GreaterThan(Float value) {
            addCriterion("Sensor14 >", value, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor14 >=", value, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14LessThan(Float value) {
            addCriterion("Sensor14 <", value, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14LessThanOrEqualTo(Float value) {
            addCriterion("Sensor14 <=", value, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14In(List<Float> values) {
            addCriterion("Sensor14 in", values, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14NotIn(List<Float> values) {
            addCriterion("Sensor14 not in", values, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14Between(Float value1, Float value2) {
            addCriterion("Sensor14 between", value1, value2, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor14NotBetween(Float value1, Float value2) {
            addCriterion("Sensor14 not between", value1, value2, "sensor14");
            return (Criteria) this;
        }

        public Criteria andSensor15IsNull() {
            addCriterion("Sensor15 is null");
            return (Criteria) this;
        }

        public Criteria andSensor15IsNotNull() {
            addCriterion("Sensor15 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor15EqualTo(Float value) {
            addCriterion("Sensor15 =", value, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15NotEqualTo(Float value) {
            addCriterion("Sensor15 <>", value, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15GreaterThan(Float value) {
            addCriterion("Sensor15 >", value, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor15 >=", value, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15LessThan(Float value) {
            addCriterion("Sensor15 <", value, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15LessThanOrEqualTo(Float value) {
            addCriterion("Sensor15 <=", value, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15In(List<Float> values) {
            addCriterion("Sensor15 in", values, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15NotIn(List<Float> values) {
            addCriterion("Sensor15 not in", values, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15Between(Float value1, Float value2) {
            addCriterion("Sensor15 between", value1, value2, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor15NotBetween(Float value1, Float value2) {
            addCriterion("Sensor15 not between", value1, value2, "sensor15");
            return (Criteria) this;
        }

        public Criteria andSensor16IsNull() {
            addCriterion("Sensor16 is null");
            return (Criteria) this;
        }

        public Criteria andSensor16IsNotNull() {
            addCriterion("Sensor16 is not null");
            return (Criteria) this;
        }

        public Criteria andSensor16EqualTo(Float value) {
            addCriterion("Sensor16 =", value, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16NotEqualTo(Float value) {
            addCriterion("Sensor16 <>", value, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16GreaterThan(Float value) {
            addCriterion("Sensor16 >", value, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16GreaterThanOrEqualTo(Float value) {
            addCriterion("Sensor16 >=", value, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16LessThan(Float value) {
            addCriterion("Sensor16 <", value, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16LessThanOrEqualTo(Float value) {
            addCriterion("Sensor16 <=", value, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16In(List<Float> values) {
            addCriterion("Sensor16 in", values, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16NotIn(List<Float> values) {
            addCriterion("Sensor16 not in", values, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16Between(Float value1, Float value2) {
            addCriterion("Sensor16 between", value1, value2, "sensor16");
            return (Criteria) this;
        }

        public Criteria andSensor16NotBetween(Float value1, Float value2) {
            addCriterion("Sensor16 not between", value1, value2, "sensor16");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNull() {
            addCriterion("UploadTime is null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNotNull() {
            addCriterion("UploadTime is not null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeEqualTo(Date value) {
            addCriterion("UploadTime =", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotEqualTo(Date value) {
            addCriterion("UploadTime <>", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThan(Date value) {
            addCriterion("UploadTime >", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UploadTime >=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThan(Date value) {
            addCriterion("UploadTime <", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThanOrEqualTo(Date value) {
            addCriterion("UploadTime <=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIn(List<Date> values) {
            addCriterion("UploadTime in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotIn(List<Date> values) {
            addCriterion("UploadTime not in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeBetween(Date value1, Date value2) {
            addCriterion("UploadTime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotBetween(Date value1, Date value2) {
            addCriterion("UploadTime not between", value1, value2, "uploadtime");
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