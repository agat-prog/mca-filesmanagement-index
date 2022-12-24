package mca.filesmanagement.index.infraestructure.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mca.filesmanagement.index.commons.IndexBpmDto;
import mca.filesmanagement.index.commons.IndexFileDto;
import mca.filesmanagement.index.infraestructure.model.IndexBpmDocument;
import mca.filesmanagement.index.infraestructure.model.IndexFileDocument;
import mca.filesmanagement.index.infraestructure.repository.IndexBpmMongoRepository;
import mca.filesmanagement.index.infraestructure.repository.IndexFilesMongoRepository;
import mca.filesmanagement.index.port.out.IRepository;

@Service
public class RepositoryAdapter implements IRepository {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IndexBpmMongoRepository indexBpmRepository;
	
	@Autowired
	private IndexFilesMongoRepository indexFilesRepository;
	
	public RepositoryAdapter() {
		super();
	}
	
	@Override
	public void save(IndexFileDto dto) {
		IndexFileDocument indexFileDocument = this.modelMapper.map(dto, IndexFileDocument.class);
		this.indexFilesRepository.save(indexFileDocument);
	}
	
	@Override
	public void save(IndexBpmDto dto) {
		IndexBpmDocument indexBpmDocument = this.modelMapper.map(dto, IndexBpmDocument.class);
		this.indexBpmRepository.save(indexBpmDocument);
	}
	
	@Override
	public boolean existsProcessInFiles(String processCode) {
		return this.indexFilesRepository.existsProcess(processCode);
	}
	
	@Override
	public IndexFileDto findByProcesCode(String processCode) {
		return toDto(this.indexFilesRepository.findByProcesCode(processCode));
	}
	
	@Override
	public boolean existsFile(String id) {
		return this.indexFilesRepository.existsById(id);
	}
	
	@Override
	public IndexFileDto findFileById(String id) {
		return toDto(this.indexFilesRepository.findById(id).orElseThrow());
	}
	
	@Override
	public boolean existsProcess(String id) {
		return this.indexBpmRepository.existsById(id);
	}
	
	@Override
	public void deleteProcess(String id) {
		this.indexBpmRepository.deleteById(id);
	}
	
	@Override
	public IndexBpmDto findBpmById(String id) {
		return toDto(this.indexBpmRepository.findById(id).orElseThrow());
	}
	
	@Override
	public Page<IndexFileDto> search(Pageable pageable) {
		Page<IndexFileDocument> pagina = this.indexFilesRepository.findAll(pageable);
		Page<IndexFileDto> pageReturn = new PageImpl<>(pagina.toList()
														.stream()
														.map(this::toDto)
														.toList(), pageable, 0);
		return pageReturn;
	}
	
	private IndexFileDto toDto(IndexFileDocument indexFileDocument) {
		return this.modelMapper.map(indexFileDocument, IndexFileDto.class);
	}
	
	private IndexBpmDto toDto(IndexBpmDocument indexBpmDocument) {
		return this.modelMapper.map(indexBpmDocument, IndexBpmDto.class);
	}
}
