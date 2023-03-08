package com.dj.cyh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName kuwei
 */
@TableName(value ="kuwei")
@Data
public class Kuwei implements Serializable {
    /**
     * 库位id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 库位编码
     */
    private String code;

    /**
     * 库位名称
     */
    private String name;

    /**
     * 库位状态
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createPre;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updatePre;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 法人id
     */
    private Integer legalpersonId;

    /**
     * 库区编码
     */
    private String kuquCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Kuwei other = (Kuwei) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreatePre() == null ? other.getCreatePre() == null : this.getCreatePre().equals(other.getCreatePre()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdatePre() == null ? other.getUpdatePre() == null : this.getUpdatePre().equals(other.getUpdatePre()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getLegalpersonId() == null ? other.getLegalpersonId() == null : this.getLegalpersonId().equals(other.getLegalpersonId()))
            && (this.getKuquCode() == null ? other.getKuquCode() == null : this.getKuquCode().equals(other.getKuquCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreatePre() == null) ? 0 : getCreatePre().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdatePre() == null) ? 0 : getUpdatePre().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getLegalpersonId() == null) ? 0 : getLegalpersonId().hashCode());
        result = prime * result + ((getKuquCode() == null) ? 0 : getKuquCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createPre=").append(createPre);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updatePre=").append(updatePre);
        sb.append(", version=").append(version);
        sb.append(", legalpersonId=").append(legalpersonId);
        sb.append(", kuquCode=").append(kuquCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}