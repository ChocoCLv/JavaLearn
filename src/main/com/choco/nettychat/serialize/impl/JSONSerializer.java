package com.choco.nettychat.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.choco.nettychat.serialize.Serializer;
import com.choco.nettychat.serialize.SerializerAlgorithm;

public class JSONSerializer implements Serializer {

    public byte getSerializerAlgorithm() {

        return SerializerAlgorithm.JSON;
    }

    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}