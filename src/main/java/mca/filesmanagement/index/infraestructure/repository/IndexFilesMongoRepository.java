package mca.filesmanagement.index.infraestructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import mca.filesmanagement.index.infraestructure.model.IndexFileDocument;

public interface IndexFilesMongoRepository extends MongoRepository<IndexFileDocument, String> {
	
	@Query(value = "{procesCode : { $eq : ?0 }}", exists = true)
	boolean existsProcess(String procesCode);
	
	@Query(value = "{procesCode : { $eq : ?0 }}")
	IndexFileDocument findByProcesCode(String procesCode);
	
	Page<IndexFileDocument> findAll(Pageable pageable);
}
