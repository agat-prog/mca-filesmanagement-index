package mca.filesmanagement.index.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mca.filesmanagement.index.commons.IndexBpmDto;
import mca.filesmanagement.index.commons.IndexFileDto;

public interface IRepository {

	void save(IndexFileDto dto);
	boolean existsFile(String id);
	IndexFileDto findFileById(String id);
	boolean existsProcess(String id);
	IndexBpmDto findBpmById(String id);
	boolean existsProcessInFiles(String processCode);
	IndexFileDto findByProcesCode(String processCode);
	void save(IndexBpmDto dto);
	void deleteProcess(String id);
	Page<IndexFileDto> search(Pageable pageable);
}
