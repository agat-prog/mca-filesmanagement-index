package mca.filesmanagement.index.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;

@Configuration
public class ServiceConfiguration {

	@Bean
	public DomainEventDispatcher fileDomainEventDispatcher(IndexService fileService, DomainEventDispatcherFactory domainEventDispatcherFactory) {
		return domainEventDispatcherFactory.make("indexDomainEventDispatcher", fileService.fileDomainEventHandlers());
	}
	
	@Bean
	public DomainEventDispatcher processDomainEventDispatcher(IndexService fileService, DomainEventDispatcherFactory domainEventDispatcherFactory) {
		return domainEventDispatcherFactory.make("indexDomainEventDispatcher", fileService.processDomainEventHandlers());
	}
}
