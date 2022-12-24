package mca.filesmanagement.index.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bpm.api.messaging.events.ProcessUpdatedEvent;
import files.api.messaging.events.FileUpdatedEvent;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import mca.filesmanagement.index.commons.IndexBpmDto;
import mca.filesmanagement.index.commons.IndexFileDto;
import mca.filesmanagement.index.port.in.IIndexUseCase;

@Service
public class IndexService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(IndexService.class);
	
	@Autowired
	private IIndexUseCase indexUseCase;

	public IndexService() {
		super();
	}
	
	public Page<IndexFileDto> search(Pageable pageable) {
		return this.indexUseCase.search(pageable);
	}
	
	protected DomainEventHandlers fileDomainEventHandlers() {
	    return DomainEventHandlersBuilder
	            .forAggregateType("mca.filesmanagement.files.domain.files.FileAggregate")
	            .onEvent(FileUpdatedEvent.class, this::handleFileUpdated)
	            .build();
	}
	
	protected DomainEventHandlers processDomainEventHandlers() {
	    return DomainEventHandlersBuilder
	            .forAggregateType("mca.filesmanagement.bpm.domain.process.ProcessAggregate")
	            .onEvent(ProcessUpdatedEvent.class, this::handleProcesUpdated)
	            .build();
	}
	
	private void handleFileUpdated(DomainEventEnvelope<FileUpdatedEvent> event) {
		FileUpdatedEvent fileUpdatedEvent = event.getEvent();
		LOGGER.info("IndexService.handleFileUpdated.event:" + fileUpdatedEvent);
		
		IndexFileDto fileDto = new IndexFileDto();
		fileDto.setDescription(fileUpdatedEvent.getDescription());
		fileDto.setId(fileUpdatedEvent.getCode());
		fileDto.setInitOption(fileUpdatedEvent.getInitOption());
		fileDto.setProcesCode(fileUpdatedEvent.getProcessCode());
		this.indexUseCase.save(fileDto);
	}
	
	private void handleProcesUpdated(DomainEventEnvelope<ProcessUpdatedEvent> event) {
		ProcessUpdatedEvent processEvent = event.getEvent();
		LOGGER.info("IndexService.handleProcesUpdated.event:" + processEvent);
		
		IndexBpmDto indexBpmDto = new IndexBpmDto();
		indexBpmDto.setDate(processEvent.getDate());
		indexBpmDto.setId(processEvent.getCode());
		indexBpmDto.setPhaseCode(processEvent.getPhaseCode());
		indexBpmDto.setPhaseName(processEvent.getPhaseName());
		this.indexUseCase.save(indexBpmDto);
	}
}
