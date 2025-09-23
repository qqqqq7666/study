package kr.co.spartamy_select_shop.repository;

import kr.co.spartamy_select_shop.entity.Folder;
import kr.co.spartamy_select_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);
    List<Folder> findAllByUser(User user);
}
