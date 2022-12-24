package mca.filesmanagement.index.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mca.filesmanagement.index.commons.IndexBpmDto;
import mca.filesmanagement.index.commons.IndexFileDto;

public interface IIndexUseCase {
	void save(IndexBpmDto dto);
	void save(IndexFileDto dto);
	Page<IndexFileDto> search(Pageable pageable);
}
