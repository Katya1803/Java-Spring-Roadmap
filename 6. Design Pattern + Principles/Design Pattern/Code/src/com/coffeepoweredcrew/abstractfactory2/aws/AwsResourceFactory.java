package com.coffeepoweredcrew.abstractfactory2.aws;

import com.coffeepoweredcrew.abstractfactory2.Instance;
import com.coffeepoweredcrew.abstractfactory2.Instance.Capacity;
import com.coffeepoweredcrew.abstractfactory2.ResourceFactory;
import com.coffeepoweredcrew.abstractfactory2.Storage;
//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new S3Storage(capMib);
	}


}
