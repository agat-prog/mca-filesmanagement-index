package mca.filesmanagement.index.infraestructure.adapter;

import mca.filesmanagement.index.commons.IndexBpmDto;
import mca.filesmanagement.index.commons.IndexFileDto;

public interface IRepository {

	void save(IndexFileDto dto);

	boolean existsFile(String id);

	IndexFileDto findFileById(String id);

	boolean existsBpm(String id);

	IndexBpmDto findBpmById(String id);

}