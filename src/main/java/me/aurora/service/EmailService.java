package me.aurora.service;

import me.aurora.domain.utils.EmailConfig;
import me.aurora.domain.vo.EmailVo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;

/**
 * @author 郑杰
 * @date 2018/09/28 7:11:23
 */
@CacheConfig(cacheNames = "email")
public interface EmailService {

    /**
     * 更新邮件配置
     * @param emailConfig
     * @param old
     * @return
     */
    @CachePut(key = "#p0.getId()")
    EmailConfig updateConfig(EmailConfig emailConfig, EmailConfig old);

    /**
     * 根据ID查询配置
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    EmailConfig findById(Long id);

    /**
     * 发送邮件
     * @param emailVo
     * @param emailConfig
     * @throws Exception
     */
    @Async
    void send(EmailVo emailVo, EmailConfig emailConfig) throws Exception;
}
