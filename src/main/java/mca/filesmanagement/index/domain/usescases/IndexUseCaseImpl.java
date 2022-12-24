package mca.filesmanagement.index.domain.usescases;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mca.filesmanagement.index.commons.IndexBpmDto;
import mca.filesmanagement.index.commons.IndexFileDto;
import mca.filesmanagement.index.port.in.IIndexUseCase;
import mca.filesmanagement.index.port.out.IRepository;

@Service
public class IndexUseCaseImpl implements IIndexUseCase {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IRepository repository;

	public IndexUseCaseImpl() {
		super();
	}

	@Override
	public Page<IndexFileDto> search(Pageable pageable) {
		return this.repository.search(pageable);
	}
	
	@Override
	public void save(IndexBpmDto dto) {
		if (this.repository.existsProcessInFiles(dto.getId())) {
			IndexFileDto updated = this.modelMapper.map(this.repository.findByProcesCode(dto.getId()), IndexFileDto.class);
			updated.setPhaseCode(dto.getPhaseCode());
			updated.setPhaseName(dto.getPhaseName());
			this.repository.save(updated);
		}
		else {
			this.repository.save(dto);
		}
	}
	
	@Override
	public void save(IndexFileDto dto) {
		IndexFileDto updated = this.getOrCreate(dto);
		updated.setDescription(dto.getDescription());
		if (this.repository.existsProcess(updated.getProcesCode())) {
			System.out.println("Existe el proceso en la tabla de index_bpm. Se recupera y se actualiza index_file");
			
			IndexBpmDto bpmDto = this.repository.findBpmById(updated.getProcesCode());
			updated.setPhaseCode(bpmDto.getPhaseCode());
			updated.setPhaseName(bpmDto.getPhaseName());
			updated.setProcesDate(bpmDto.getDate());
			
			// Se elimina el registro que ha servido de temporal
			this.repository.deleteProcess(updated.getProcesCode());
		}
		
		this.repository.save(updated);
	}
	
	private IndexFileDto getOrCreate(IndexFileDto dto) {
		IndexFileDto retorno = dto;
		if (this.repository.existsFile(dto.getId())) {
			retorno = this.repository.findFileById(dto.getId());
		}
		return retorno;
	}
}
