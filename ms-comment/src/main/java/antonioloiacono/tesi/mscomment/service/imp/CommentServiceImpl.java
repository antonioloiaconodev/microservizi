package antonioloiacono.tesi.mscomment.service.imp;


import antonioloiacono.tesi.mscomment.dto.CommentCreateDto;
import antonioloiacono.tesi.mscomment.dto.CommentDto;
import antonioloiacono.tesi.mscomment.dto.CommentUpdateDto;
import antonioloiacono.tesi.mscomment.entity.Comment;
import antonioloiacono.tesi.mscomment.exception.RecordNotFoundException;
import antonioloiacono.tesi.mscomment.repository.CommentRepository;
import antonioloiacono.tesi.mscomment.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(
            CommentRepository commentRepository,
            ModelMapper modelMapper
    ) {
        super();
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<CommentDto> findAllComments() {
        return commentRepository.findAll().stream().map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public CommentDto findCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No comment found with the id: " + id));
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto createComment(CommentCreateDto commentCreateDto) {
        Long userId = commentCreateDto.getUserId();
        Long videogameId = commentCreateDto.getVideogameId();
        String comment = commentCreateDto.getComment();
        Comment commentCreate = new Comment();
        commentCreate.setUserId(userId);
        commentCreate.setVideogameId(videogameId);
        commentCreate.setComment(comment);
        return modelMapper.map(commentRepository.save(commentCreate), CommentDto.class);
    }

    @Override
    public CommentDto updateComment(Long id, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No comment found with the id: " + id));
        if (commentUpdateDto.getComment() != null){
            comment.setComment(commentUpdateDto.getComment());
        }
        return modelMapper.map(commentRepository.save(comment), CommentDto.class);
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No comment found with the id: " + id));
        commentRepository.delete(comment);
    }

    @Override
    public void deleteAllCommentsByVideogameId(Long videogameId) {
        commentRepository.deleteAllByVideogameId(videogameId);
    }
}