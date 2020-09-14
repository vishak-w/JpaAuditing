package com.example.demo.AuditorAware;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.audit.Auditable;
import com.example.demo.userEntity.User;
@Service
public class AuditorAwareImpl implements AuditorAware<String>{
	
	User user=new User();
	Auditable audit=new Auditable();
	@Override
	public Optional<String> getCurrentAuditor()
	{
		String   name1= audit.getCreatedBy();
		String name=user.getFirstName();
		System.out.println("name in auditor is...." +" " +name1);
		return Optional.of("mak");
	
	}
	

}
